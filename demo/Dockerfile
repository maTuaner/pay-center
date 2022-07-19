# 基础镜像
FROM openjdk:17-jdk-slim
# 容器运行目录
RUN mkdir -p /app
# 更新并删除多余的包，设置编码格式
ENV LANG C.UTF-8
# 工作目录
WORKDIR /app
# 复制目标到容器  注意与ADD区别
COPY ./target/demo-*.jar /app/hkuo-demo.jar
# 暴漏端口号
EXPOSE 18080
# 执行操作
CMD [ "java", "-jar", "-Dfile.encoding=UTF-8", "-Djava.security.egd=file:/dev/./urandom", "hkuo-demo.jar", "--server.port=18080" ]
