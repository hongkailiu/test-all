#!/bin/bash

#sudo docker push docker.io/hongkailiu/test-webapp:first
#sudo docker pull docker.io/hongkailiu/test-webapp:first
#sudo docker run -t -i -p 8888:8080 docker.io/hongkailiu/test-webapp:first
#sudo docker build -t docker.io/hongkailiu/test-webapp:first .

echo "Not implemented yet"
exit 1

PROJECT=proj_hajp
REGISTRY=armdocker.rnd.ericsson.se
SUBPROJECT=core


if [ -z "$1" ]
  then
    echo "No arguments supplied"
    exit 1
fi

export http_proxy=
export https_proxy=

set -e

if [ $1 == "buildRelease" ]
  then
    ./packageJenkins.sh
    docker build --no-cache=true -t $REGISTRY/$PROJECT/$SUBPROJECT:$VERSION .
    rm -f *.hpi
    rm -f *.war
fi

if [ $1 == "buildSnapshot" ]
  then
    ./packageJenkins.sh
    docker build --no-cache=true -t $REGISTRY/$PROJECT/$SUBPROJECT:SNAPSHOT .
    rm -f *.hpi
    rm -f *.war
fi

if [ $1 == "runRelease" ]
  then
   	docker run -p 8080:8080 $REGISTRY/$PROJECT/$SUBPROJECT:$VERSION
fi

if [ $1 == "runSnapshot" ]
  then
   	docker run -p 8080:8080 $REGISTRY/$PROJECT/$SUBPROJECT:SNAPSHOT
fi

if [ $1 == "pushRelease" ]
  then
    docker push $REGISTRY/$PROJECT/$SUBPROJECT:$VERSION
fi

if [ $1 == "pushSnapshot" ]
  then
    docker push $REGISTRY/$PROJECT/$SUBPROJECT:SNAPSHOT
fi
