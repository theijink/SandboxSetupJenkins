# SandboxSetupJenkins
Sandbox project to play around with Maven and Jenkins

## Setup Centos 8

- Open parallels and create Centos8 VM
- Install Parallels Tools
    - Parallels upper-left taskbar -> Devices -> CD/DVD -> Connect Image
    - Select image from Parallels Desktop application -> Contents -> Resources -> Tools -> prl-tools-<os>.iso
- update yum [https://stackoverflow.com/questions/70963985/error-failed-to-download-metadata-for-repo-appstream-cannot-prepare-internal]
```
cd /etc/yum.repos.d/
```
```
sudo sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
sudo sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*
sudo yum update -y
```
```
sudo systemctl reboot
```
- install development tools [https://computingforgeeks.com/install-python-3-on-centos-rhel-7/]
```
sudo yum -y install epel-release
sudo yum install wget make cmake gcc bzip2-devel libffi-devel zlib-devel
```
```
sudo yum -y groupinstall "Development Tools"
```
## Python version
- install python version [https://tecadmin.net/install-python-3-11-on-centos-fedora/]
    - get software
    - configure build
    - install 
    - remove the downloaded file
```
cd /usr/src
wget https://www.python.org/ftp/python/3.11.9/Python-3.11.9.tgz
tar xvf Python-3.11.9.tgzcd OP
```
```
cd Python-3.11.3 
sudo ./configure --enable-optimizations 
sudo make altinstall 
```
```
sudo rm Python-3.11.9.tgz
```

## Java
- install java 11 using yum [https://stackoverflow.com/questions/53378483/installing-openjdk-11-on-centos-using-yum]
```
yum install java-11-openjdk-devel
```
- check java configurations available on machine
```
alternatives --config java
```


## Jenkins
- Install and configure Jenkins for centos [https://www.geeksforgeeks.org/installation-of-jenkins-in-cent-os/]
- Add jenkins repo to centos repo
```
sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
```
```
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key
```
```
sudo yum upgrade

```
```
sudo yum -y install jenkins
```
```
sudo systemctl enable jenkins
sudo systemctl start jenkins
```
- Navigate in browser to localhost:8080 and log in with the password in 
```
sudo vi /var/lib/jenkins/secrets/initialAdminPassword
```
- Install the plugins and continue as admin. Enter the jenkins URL (localhost:8765)




## Maven
- install maven
```
sudo yum -y install maven
```
- instantiate maven project
```
mvn archetype:generate -DgroupId=com.theijink -DartifactId=SandboxSetupJenkins -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-archetype -DarchetypeVersion=1.4
```


## configure Jenkins job
- create Job
- GitHub project url -> set correct
- Source Code Management -> Git -> set repository url correct and branches to build
- Build Steps -> Invoke top-level Maven targets -> version default, goals clean install


## maven project add tests
```bash
Archetype
|- pom.xml
|- src
|   |- main
|   |   |- java
|   |   |   |- com
|   |   |   |   |-theijink
|   |   |   |   |   |-App.java
|   |- test
|   |   |- java
|   |   |   |- com 
|   |   |   |   |- theijink
|   |   |   |   |   |- CucumberSpringConfiguration.java
|   |   |   |   |   |- GreetingStepDefinition.java
|   |   |   |   |   |- RunCucumberTest.java
|   |   |- resources
|   |   |   |- cucumber.properties
|   |   |   |- cucumber.xml
|   |   |   |- features
|   |   |   |   |- greeting.feature
```

