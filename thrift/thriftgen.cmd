#!/bin/sh

THRIFT_EXE=thrift
THRIFT_VER=10
APP_NAME=common

#Java
mkdir -p $APP_NAME-thrift/
rm -f $APP_NAME-thrift/gen-java/*/*/*/*/*/*
#zactransaction	
$THRIFT_EXE --gen java -o $APP_NAME-thrift $APP_NAME.thrift

#-------------------------------------------------------------------------------
#Java build & deploy

PROJECT_NAME=$APP_NAME-thrift
PROJECT_DIR=$APP_NAME-thrift
VERSION=1.0.0.0

#common variables
DEPLOY_DIR=../lib/
DEPLOY_JAR="$PROJECT_NAME"-"$THRIFT_VER"-"$VERSION".jar

#build
ant -f $PROJECT_DIR/build.xml clean
ant -f $PROJECT_DIR/build.xml -Djavac.debug=false -Djar.compress=true -Ddist.jar=dist/$DEPLOY_JAR jar

#deploy to lib
mkdir -p $DEPLOY_DIR
cp -f $PROJECT_DIR/dist/$DEPLOY_JAR $DEPLOY_DIR

#clean
#ant -f $PROJECT_DIR/build.xml clean

