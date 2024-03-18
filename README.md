# Boilerplate for k8s apps

Objective: To develop a standardized Spring base java project boilerplate, to rapidly initiate new services
within a one-day timeframe.

How to use this boilerplate: When creating a new service, simple chose this boiler-plate as template and start. Search and 
replace all occurrences of 'boilerplate' and 'boiler-plate' with your service name. 


# Contents and the Guidelines
## Spring Basics

- use [actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html?query=health%27%20target=_blank%3E%3Cb%3Ehealth%3C/b%3E%3C/a%3E-groups)
- Separate transfer objects with suffix:
    - controller objects with -Request and -Response
    - queue objects with -Message
    - callback/webhooks with -Notification
- validate transfer objects with `import jakarta.validation.constraints.*` using `@valid`
- test controllers without the whole application context
- use springdoc and swagger for openapi documentation, upload it to bump.sh

## Docker basics

- Read [docker caching](https://docs.docker.com/build/cache/)
- and docker [env variables](https://docs.docker.com/build/building/env-vars/)
- Do NOT run HEALTHCHECKS (this should be done by orchestration, let the pod die if image fails)
- Do NOT put ENV variables into the Dockerfile or use scripts to set them, this should be done by the orchestration/K8s with 
    secrets and configmaps

## AWS Basics

- use [localstack](https://github.com/localstack/localstack) for local development
- always publish events through SNS
- configure SNS through beans 
- use [spring-cloud-aws-messaging](https://cloud.spring.io/spring-cloud-aws/reference/html/#_messaging) for SNS/SQS

## k8s Basics

- learn [kubectl](https://kubernetes.io/docs/reference/generated/kubectl/kubectl-commands#delete)
- Define liveness and readiness probes in your deployment to help Kubernetes know when your app is ready to serve
  traffic and when to restart containers. They are not the same!
- Use ConfigMaps for non-sensitive configuration data and Secrets for sensitive data, referencing them appropriately in
  your deployment configurations.
- use Helm 3 for k8s resources definitions
    - Use the command helm create [chart-name] to create a new chart with the default structure. (no copy-paste)
    -
- for local development, try [minikube](https://minikube.sigs.k8s.io/)
    - 'brew install minikube'
    - 'minikube image load <image name>'
    - create a deployment and service(nodeport)
    - expose the port 'minikube service <service name> --url'
    - enjoy
- ingress
    - [helm](https://helm.sh/docs/intro/quickstart/)
    - {host}/{service-name}/{version}/{path}
        - [ ] get the version from pom.xml

## K24 Basics

- Add your repo into codacy and generate a token on
  the [settings page](https://app.codacy.com/gh/kfzteile24/boilerplate-k8s-app/settings/coverage)
- use the badge on your readme

# Roadmap

- database
    - [ ] jpa
    - [ ] liquidbase

- spring
    - [x] actuator
    - [x] springdoc & bumpsh
    - [ ] env only controllers
    - [ ] tests
    - [ ] mvn profiles
    - [ ] configuration NOT in maven
- k8s
    - [x] ingress
    - [ ] cronjob
    - [x] configmaps
- localstack
    -  [ ] s3
    -  [ ] sns ingress
    -  [ ] sqs

