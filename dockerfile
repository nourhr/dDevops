FROM java:8
ADD /target/timesheet-devops-1.0.jar timesheet-devops.jar
ENTRYPOINT ["java","-jar","timesheet-devops.jar"]
