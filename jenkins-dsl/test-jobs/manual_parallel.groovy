multiJob("manual_parallel") {
	description("multi phase job inside a multi phase job")

	concurrentBuild(false)
	steps {
		phase("Parallel Test") {
      parallel(
        {
          parallel(
            {
              phaseJob("allure_behave_latest") {
                killPhaseCondition("NEVER")
              }
              phaseJob("allure_behave_old") {
          			killPhaseCondition("NEVER")
          		}
            },
            {
              phaseJob("allure_behave") {
                killPhaseCondition("NEVER")
              }
            }
          )

        }
      )

			continuationCondition("ALWAYS")
			executionType("PARALLEL")
		}
	}
}
