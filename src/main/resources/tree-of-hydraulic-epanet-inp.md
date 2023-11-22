## Input File Format

- Option
    - hydraulic simulation
        - components
            - pump
                - Global pump efficiency (percent)
        - flow unit: CMH
        - convergence
            - maximum trials
            - ACCURACY
            - maximum head loss error
            - maximum flow change
    - Water quality
        - TOLERANCE

## OPTIONS

- OPTIONS
    - Hydraulics
        - Units of Measurement
            - UNITS
                - LPS
                - LPM
                - MLD
                - CMH
                - CMD
        - component
            - pipe
                - HEADLOSS
                    - H-W: Hazen-Williams
                    - D-W: Darcy-Weisbach
                    - C-M: Chezy-Manning
            - junction
                - demand
                    - PATTERN (Default Pattern)
                    - DEMAND MULTIPLIER
                - emitter
                    - EMITTER EXPONENT
        - fluid
            - VISCOSITY (Relative Viscosity)
            - SPECIFIC GRAVITY
        - solve
            - DEMAND MODEL
                - DDA
                - PDA
                    - MINIMUM PRESSURE
                    - REQUIRED PRESSURE
                    - PRESSURE EXPONENT
            - run
                - TRIALS (Maximum Trials)
            - convergence
                - ACCURACY
                - HEADERROR (Max. Head Error)
                - FLOWCHANGE (Max. Flow Change)
            - UNBALANCED (If Unbalanced)
                - STOP
                - CONTINUE
                - CONTINUE n
        - result
            - HYDRAULICS
                - SAVE
                - USE
    - Quality
        - QUALITY
            - NONE
            - CHEMICAL
            - AGE
            - TRACE
        - DIFFUSIVITY (Relative Diffusivity)
        - TOLERANCE (Quality Tolerance)

## TIMES

- TIMES
    - total
        - DURATION
    - input
        - hydraulic
            - HYDRAULIC TIMESTEP
        - quality
            - QUALITY TIMESTEP
        - pattern
            - PATTERN TIMESTEP
            - PATTERN START
    - solve
        - START CLOCKTIME
        - RULE TIMESTEP
    - output
        - report
            - REPORT TIMESTEP
            - REPORT START
        - STATISTIC
            - NONE
            - AVERAGED
            - MINIMUM
            - MAXIMUM
            - RANGE