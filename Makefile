## This make file is not part of the boilerplate, feel free to ignore/delete it


## GIT
m ?= default message [skip ci]
branch=$(shell git rev-parse --abbrev-ref HEAD)
platform ?= qa-2

cp: c p
p:
	echo $(branch)
	git push origin $(branch)
c:
	echo $(m)
	git commit -am "$(m)"

d:
	mvn clean install -DskipTests=true
	docker build -t boilerplate:latest .
	docker run -p 8080:8080 boilerplate:latest

i:
	helm upgrade --install --recreate-pods  --force boilerplate-k8s-app helm/ --namespace default \
	--values helm/values.yaml \
	--values helm/values/local.yaml
	 kubectl rollout restart deployment boiler-plate -n default

config:
	 aws eks update-kubeconfig --region eu-central-1 --name k24-${platform}

id:
	kubectl get pods | grep boiler-plate | awk '{print $1}'

run:
	mvn clean install -DskipTests=true
	java -jar target/boilerplate-0.1.jar

logs:
	$(eval PODNAME=$(shell sh -c "kubectl get pods | grep boiler | grep Running" | awk '{print $$1}'))
	kubectl logs -f $(PODNAME)

exec:
	$(eval PODNAME=$(shell sh -c "kubectl get pods | grep boiler | grep Running" | awk '{print $$1}'))
	kubectl exec -it $(PODNAME) -- /bin/sh

deploy:
	gh workflow run deploy.yml  -f Platform=$(platform) --ref $(branch)
