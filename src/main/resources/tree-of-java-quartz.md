# Quartz

- Quartz API
    - Job
    - JobDetail
        - Quartz JobBuilder
        - Spring JobDetailFactoryBean
    - Scheduler
        - Quartz StdSchedulerFactory
        - Spring SchedulerFactoryBean
    - Trigger
        - Quartz TriggerBuilder
        - Spring SimpleTriggerFactoryBean
    - JobStore
        - component
            - JobDetail
            - Trigger
        - store
            - In-Memory
            - JDBC
                - JobStoreTX
                - JobStoreCMT


- Quartz Role
    - Scheduler (coordinator)
        - JobDetail (what)
            - Job
        - Trigger (when)
