#!/bin/bash
DOCKER_IMAGE=$1
REPO_NAME=$2
echo "Uploading to ECR "$DOCKER_IMAGE
docker push $AWS_ACCOUNT_ID.dkr.ecr.$AWS_DEFAULT_REGION.amazonaws.com/$REPO_NAME     