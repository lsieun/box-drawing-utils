# EPANET Dev

## Hydraulic Analysis

- epanet
    - open
        - EN_open()
    - hydraulic
        - complete
            - solve
                - EN_solveH()
        - step by step
            - open
                - EN_openH()
            - init
                - EN_initH()
            - loop
                - EN_runH()
                - EN_nextH()
            - close
                - EN_closeH()
    - water quality
        - complete
            - solve
                - EN_solveQ()
        - step by step
            - open
                - EN_openQ()
            - init
                - EN_initQ()
            - loop
                - EN_runQ()
                - EN_nextQ()
                - EN_stepQ()
            - close
                - EN_closeQ()
    - close
        - EN_close()

## Water Quality Analysis

