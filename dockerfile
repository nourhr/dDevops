FROM java:8
EXPOSE 8094
ADD /target/timesheet-devops-1.0.jar timesheet-devops.jar
ENTRYPOINT ["java","-jar","timesheet-devops.jar"]