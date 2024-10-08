package nab;

public class jenkinFile {
}



//def isJava = true;
//// git repo
//def gitUrl = "https://git.vsmart.net/vinhomes-resident/vinhomesapp-be.git"
//def gitBranch = "uat"
//
////Theo dung folder jenkins: VHR, coms, pms, csi
//def envProject = "vhr"
//// dev, uat, stg, prod
//def envTarget = gitBranch
//
//// Registry
//def registryDomain = "harbor.vinhomes.vn"
//
//// project
//def namespace ="${envProject.toLowerCase()}-${envTarget}"
//def projectName = "vinhome-iam"
//
//// Helm Values Config
//def projectHelmConfig = "${envProject}/DEVOPS/helmvalues"
//def helmWorkspace = "/var/lib/jenkins/workspace/${projectHelmConfig}"
//def helmDefaultValues = "values-${envProject.toLowerCase()}-${envTarget}.yaml"
//def helmValues = "${envTarget.toUpperCase()}/${projectName}/${helmDefaultValues}"
//def helmChart = "technosvc"
//
//// Version
//def date = new Date()
//def version = "${projectName}-${params.VERSION}-${envTarget}-${BUILD_NUMBER}.${date.format("MMdd", TimeZone.getTimeZone("GMT+7"))}"
//currentBuild.displayName = version
//
//// Build
//def dockerBuildCommand = "--build-arg PROJECT=${projectName} ./"
//def mavenBuild = "echo 1"
//if (isJava == true) {
//mavenBuild = "/bin/bash ./mvnw -s ${helmWorkspace}/jenkins/m2/${envProject.toLowerCase()}-settings.xml -P${envTarget} -DskipTests clean package"
//        }
//
//def releaseModule
//pipeline {
//    agent any
//    tools {
//        jdk "jdk11"
//    }
//    stages {
//        stage('Update helm value') {
//            steps {
//                build job: "${projectHelmConfig}", wait: true
//            }
//        }
//        stage("Checkout project") {
//            steps {
//                script {
//                    releaseModule = load "${helmWorkspace}/cicd/release.groovy"
//                    releaseModule.init(envProject, envTarget, projectName, gitUrl, gitBranch, version, registryDomain)
//                }
//            }
//        }
//        stage("Build And Push Docker Image") {
//            steps {
//                script {
//                    sh "git reset --hard"
//                    sh "git clean -f"
//                    sh "${mavenBuild}"
//                    app = docker.build(DOCKER_IMAGE_NAME, dockerBuildCommand)
//                    docker.withRegistry(DOCKER_REGISTRY, registryCredential) {
//                        app.push(version)
//                    }
//                    sh "docker rmi ${DOCKER_IMAGE_NAME} -f"
//                    sh "docker rmi ${DOCKER_IMAGE}:${version} -f"
//                }
//            }
//        }
//        stage("Apply k8s") {
//            steps {
//                script {
//                    sh "helm upgrade $projectName $deployDirectory/$helmChart/ -f $deployDirectory/$helmDefaultValues -f $deployDirectory/$helmValues --kubeconfig=$kubeconfig --namespace=$namespace -i --atomic --cleanup-on-fail --wait --timeout=5m --set fullnameOverride=$projectName,image.repository=${DOCKER_IMAGE},image.tag=${version}"
//                }
//            }
//        }
//    }
//
//    post {
//        success {
//            script {
//                releaseModule.buildPostSuccess()
//            }
//        }
//    }
//}
