## Understand Helm Charts:

A Helm chart is a collection of files that describe a related set of Kubernetes resources. It typically includes a
Chart.yaml (chart metadata), values.yaml (default configuration values), and templates for Kubernetes resource files.

## Create Your Helm Chart:

Use the command helm create [chart-name] to create a new chart with the default structure. This will create a directory
with the necessary files.

## Configure Your Chart:

Modify the values.yaml file to suit your Java Spring application's needs, such as application properties, service type,
and resource limits.
Adapt the templates in the templates/ directory, which may include Deployment, Service, ConfigMap, and other Kubernetes
objects. Ensure they reference values from values.yaml.

## Package Your Chart:

Once your chart is ready, package it using helm package [chart-directory]. This command creates a chart archive that can
be deployed to a Kubernetes cluster.

## Deploy Your Application:

Use helm install [release-name] [chart-archive] to deploy your Java Spring application to Kubernetes. Helm will
interpret your chart and create the necessary Kubernetes resources.

## Use Separated Values

Base Values File:

Start with a values.yaml file in your Helm chart. This file will contain default values that are common across all
environments.
Environment-Specific Values Files:

Create separate values files for each environment. For example:
values-dev.yaml for development
values-staging.yaml for staging
values-prod.yaml for production
Override Default Values:

In each environment-specific file, override the default values from values.yaml as needed. For instance, you might have
different resource limits, image tags, or configuration parameters for each environment.
Deployment Command:

When deploying your application, specify the environment-specific values file using the -f or --values flag with the
helm install or helm upgrade command. For example:
For development: `helm install my-app ./my-chart -f values-dev.yaml`
For production: `helm install my-app ./my-chart -f values-prod.yaml`
