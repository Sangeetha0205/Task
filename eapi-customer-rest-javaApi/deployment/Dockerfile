# Please modify FROM to <non-prod ACR being used for your builds>.azurecr.io/iceleap/cicd/base/ubuntu:18.04
FROM ubuntu:18.04
ENV HOME_PATH=/usr/src/app

# The following section needs to go away and should be in the base image
RUN apt-get update -qq && apt-get install -qqy zip wget git curl unzip sudo xz-utils gnupg
# Install Zulu OpenJDK 8
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 0x219BD9C9 && \
    echo "deb http://repos.azulsystems.com/ubuntu stable main" >> /etc/apt/sources.list.d/zulu.list && \
    apt-get -qq update && \
    apt-get -qqy install zulu-8=8.31.0.1 && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p ${HOME_PATH}
WORKDIR ${HOME_PATH}
COPY target/*SNAPSHOT.jar ${HOME_PATH}/waglobsbujavaboilerplt.jar

EXPOSE 8080
CMD [ "java", "-jar", "${HOME_PATH}/waglobsbujavaboilerplt.jar" ]
