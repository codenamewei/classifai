#!/usr/bin/env bash

CLASSIFAI_VERSION="2.0.0-alpha1"
CLASSIFAI_JAR="classifai-uberjar-$CLASSIFAI_VERSION-dev.jar"

export CLASSIFAI_ABSPATH_JAR="$HOME/.m2/repository/ai/classifai/classifai-uberjar/$CLASSIFAI_VERSION/$CLASSIFAI_JAR"

rm $CLASSIFAI_ABSPATH_JAR

./mvnw -Puberjar -Dmaven.test.skip=true clean install

/home/wei/.jdks/adopt-openjdk-14.0.2/bin/java -jar $CLASSIFAI_ABSPATH_JAR $@
