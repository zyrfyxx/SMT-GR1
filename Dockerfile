# use Ubuntu 22.04 as basic image
FROM ubuntu:22.04

# 
ENV DEBIAN_FRONTEND=noninteractive

RUN sed -i "s|archive.ubuntu.com|mirrors.tuna.tsinghua.edu.cn|g" /etc/apt/sources.list

# update
RUN apt-get update && \
    apt-get install -y \
    openjdk-21-jdk \
    python3 python-is-python3 \
    python3-pip \
    maven \
    && apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# set JAVA_HOME 
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# version
RUN java -version && \
    python3 --version && \
    pip3 --version && \
    mvn -version

# set dir
WORKDIR /app

# cp
COPY SMGR1 /app/SMGR1
COPY SMT_GR1_DataSet /app/SMT_GR1_DataSet
COPY pythonProject /app/pythonProject
COPY run.sh /app/run.sh

# 
CMD [ "bash" ]
