## Input File Format

## JUNCTIONS

- JUNCTION
    - node
        - name
        - description
        - position
            - coordinate
                - x
                - y
            - elevation
    - hydraulic
        - demand
            - single
                - base demand
                - demand pattern
            - multiple
                - demand categories
        - emitter
            - emitter coefficient
    - quality
        - initial quality
        - source quality

## RESERVOIR

- RESERVOIR
    - node
        - name
        - description
        - position
            - coordinate
                - x
                - y
            - elevation
    - hydraulic
        - head
            - total head
            - head pattern
    - quality
        - initial quality
        - source quality

## TANK

- TANK
    - node
        - name
        - description
        - position
            - coordinate
                - x
                - y
            - elevation
    - hydraulic
        - diameter
        - depth
            - initial level
            - minimum level
            - maximum level
        - volume
            - minimum volume
            - volume curve
            - can overflow
    - quality
        - quality
            - initial quality
            - source quality
        - reaction
            - mixing model
            - mixing fraction
            - reaction coefficient

## PIPE

- PIPE
    - link
        - name
        - description
        - node
            - start node
            - end node
        - length
        - diameter
    - hydraulic
        - head loss
            - roughness coefficient
            - minor loss coefficient
        - switch
            - initial status (OPEN/CLOSE/CV)
    - quality
        - reaction
            - bulk coefficient
            - wall coefficient

## PUMP

- PUMP
    - link
        - name
        - description
        - node
            - start node
            - end node
    - hydraulic
        - energy
            - power
                - constant
                    - power
                - variable
                    - pump curve
            - speed
                - speed setting
                - time pattern
            - efficiency
                - efficiency curve
            - price
                - energy price
                - price pattern
        - switch
            - initial status (OPEN/CLOSED)
    - quality

## VALVE

- VALVE
    - link
        - name
        - description
        - node
            - start node
            - end node
        - diameter
    - hydraulic
        - type
            - PRV/PSV/PBV/FCV/TCV/GPV
        - setting
            - pressure: PRV/PSV/PBV
            - flow: FCV
            - loss coefficient: TCV
            - head loss curve: GPV
        - head loss
            - minor loss coefficient
        - switch
            - fixed status (None/OPEN/CLOSED)
    - quality

## OPTIONS

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

## STATUS

- STATUS
    - Pipe
        - Status
            - OPEN (default)
            - CLOSED
    - Pump
        - Status
            - OPEN (default)
            - CLOSED
        - Setting
            - speed setting
    - Valve
        - Status
            - OPEN
            - CLOSED
            - ACTIVE (default)
        - Setting
            - valve setting

## TIMES

- TIMES
    - whole
        - since
            - START CLOCKTIME
        - total
            - DURATION
    - local
        - step
            - HYDRAULIC TIMESTEP
            - QUALITY TIMESTEP
            - RULE TIMESTEP
            - PATTERN TIMESTEP
            - REPORT TIMESTEP
        - when
            - PATTERN START
            - REPORT START
    - STATISTIC
        - NONE
        - AVERAGED
        - MINIMUM
        - MAXIMUM
        - RANGE
