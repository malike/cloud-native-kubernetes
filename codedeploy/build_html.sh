#!/bin/bash
echo "Building HTML IMAGE "
cd ../frontend/
echo "Switching directory " `pwd` 
export TAG=`if [ "$TRAVIS_BRANCH" == "master" ]; then echo "latest"; else echo $TRAVIS_BRANCH ; fi`
export IMAGE_NAME=stmalike/$SERVICE_DIR
docker build -f Dockerfile -t $IMAGE_NAME:$TAG .
docker tag $IMAGE_NAME:$COMMIT $IMAGE_NAME:$TAG
docker tag $IMAGE_NAME:$COMMIT $IMAGE_NAME:travis-$TRAVIS_BUILD_NUMBER