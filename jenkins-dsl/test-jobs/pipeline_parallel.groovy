buildTrigger = build("pipeline_parallel")

description("multi phase job inside a multi phase job")
parallel(
	{
		parallel(
			{
				buildA = build("allure_behave_latest")
			},
			{
				buildB = build("allure_behave_old")
			}
		)
	}
)
