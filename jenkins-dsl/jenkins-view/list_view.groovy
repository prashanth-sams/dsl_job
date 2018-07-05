listView("list_view") {
    description("List of tests with allure report")
    jobs {
        names(
            'allure_behave',
            'allure_behave_new',
            'allure_behave_old'
        )
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
        console()
    }
}
