pipeline {
    environment {
        registry = "rohitkatlaa/calc_dev_ops"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    // The “agent” section configures on which nodes the pipeline can be run. 
    // Specifying “agent any” means that Jenkins will run the job on any of the 
    // available nodes.
		agent any 
    stages {
        stage('Git Pull') {
            steps {
                // Get code from a GitHub repository
                // Make sure to add your own git url and credentialsId
								git url: 'https://github.com/rohitkatlaa/CalcDevOps.git', branch: 'master',
                 credentialsId: 'jenkins-ansible'
            }
        }
        stage('Maven Build') {
            steps {
                // Maven build, 'sh' specifies it is a shell command
                sh 'mvn clean install'
            }
        }
        stage('Building Image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:latest"
            }
        }
        stage('Ansible Deploy') {
            steps {
                //Ansible Deploy to remote server (managed host)
                ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible',inventory: 'inventory', playbook: 'playbook.yml'

            }
        }
    }
}