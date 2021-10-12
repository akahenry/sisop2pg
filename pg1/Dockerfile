FROM ubuntu:18.04

RUN apt-get update

RUN apt-get -y install software-properties-common

RUN apt-add-repository -y universe
   
RUN apt-get -y update 
    
RUN apt-get -y install maven

RUN apt-get -y install openjdk-11-jdk-headless

WORKDIR /app/

COPY ./ /app/

CMD mvn jetty:run