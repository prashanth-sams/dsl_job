job("allure_behave") {
	description("basic test")
	keepDependencies(false)
	triggers {
		githubPush()
  }
	scm {
		git {
			remote {
				github("prashanth-sams/DanatOnline", "https")
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
}
