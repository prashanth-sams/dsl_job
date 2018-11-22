multiJob("parallels") {
	description("multi phase job inside a multi phase job")

	concurrentBuild(false)
	steps {
		phase("Parallel Test") {
			phaseJob("allure_behave") {
				currentJobParameters(true)
				exposedScm(false)
				disableJob(false)
				abortAllJobs(true)
				killPhaseCondition("FAILURE")
			}
			phaseJob("allure_behave_new") {
				currentJobParameters(true)
				exposedScm(false)
				disableJob(false)
				abortAllJobs(true)
				killPhaseCondition("FAILURE")
			}
			phaseJob("allure_behave_old") {
				currentJobParameters(true)
				exposedScm(false)
				disableJob(false)
				abortAllJobs(true)
				killPhaseCondition("FAILURE")
			}
			continuationCondition("ALWAYS")
			executionType("PARALLEL")
		}
	}
	pollSubjobs(false)
}
