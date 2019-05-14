job("allure_behave") {
	description("basic test")
	keepDependencies(false)
	properties {
     priority(1)
     githubProjectUrl('https://github.com/prashanth-sams/DanatOnline/')
  }
	triggers {
		githubPush()
  }
	scm {
		git {
			remote {
				url('git@github.com:prashanth-sams/DanatOnline.git')
			}
			branch("*/master")
		}
	}
	disabled(false)
	concurrentBuild(true)
	steps {
    shell(readFileFromWorkspace('jenkins-dsl/test-jobs/allure_behave.sh'))
		shell("behave -f allure_behave.formatter:AllureFormatter -o allure-results features/scenarios/login.feature -D browser=chrome -D env=UAT")
    shell(readFileFromWorkspace('jenkins-dsl/test-jobs/allure_behave_post.sh'))
	}
	publishers {
		postBuildTask {
			task('.*',readFileFromWorkspace('jenkins-dsl/test-jobs/update_1.sh'),false,true)
		}
	}
}
