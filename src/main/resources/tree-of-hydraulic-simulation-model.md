# hydraulic-simulation-model

## The Network Model

- The Network Model
    - Physical Components
        - nodes
            - Junctions
            - Reservoirs
            - Tanks
            - Emitters
        - links
            - Pipes
            - Pumps
            - Valves
    - Non-Physical Components
        - Curves
            - Pump Curve
            - Pump Efficiency Curve
            - Tank Volume Curve
            - Valve Headloss Curve
        - Time Patterns
        - Controls
            - Simple Controls
            - Rule-Based Controls

- Hydraulic Simulation Model
    - input
        - reservoir
            - reservoir levels
        - junction
            - junction demands
        - tank
            - tank levels
    - output
        - junctions
            - hydraulic heads
        - links
            - flow rates

### Valve

- Valve
    - special
        - pressure
            - Pressure Reducing Valve (PRV)
            - Pressure Sustaining Valve (PSV)
            - Pressure Breaker Valve (PBV)
        - flow
            - Flow Control Valve (FCV)
            - Throttle Control Valve (TCV)
    - general
        - General Purpose Valve (GPV)

## Parameters

### Pipe

- Pipe Parameters
    - ID label of pipe
    - ID of start node
    - ID of end node
    - Length
    - Diameter
    - Roughness coefficient
    - Minor loss coefficient
    - Status (OPEN, CLOSED, or CV)

### Pump

- Pump Parameters
    - Pump ID
    - ID of start node
    - ID of end node
    - Keyword and Value
        - POWER – power value for constant energy pump, hp (kW)
        - HEAD - ID of curve that describes head versus flow for the pump
        - SPEED - relative speed setting (normal speed is 1.0, 0 means pump is off)
        - PATTERN - ID of time pattern that describes how speed setting varies with time

## Analysis Algorithms

### Fixed Demand Model

- Fixed Demand Model
    - Pipe Head Loss
    - Pump Head Loss

#### Pipe Head Loss

- Pipe Head Loss (h)
    - flow (q)
    - resistance coefficient (r)
        - Hazen-Williams Formula
            - pipe Hazen-Williams roughness coefficient
            - pipe diameter
            - pipe length
        - Darcy-Weisbach Formula
            - pipe friction factor
            - pipe Darcy-Weisbach roughness coefficient
            - pipe diameter
            - pipe flow rate
            - pipe length
        - Chezy-Manning Formula
            - pipe Manning roughness coefficient
            - pipe diameter
            - pipe length
    - flow exponent (n)
        - Hazen-Williams: 1.852
        - Darcy-Weisbach: 2
        - Chezy-Manning: 2
    - minor loss coefficient (m)
        - pipe Minor loss coefficient

#### Pump Head Loss

- Pump Head Loss (h)
    - flow (q)
    - pump shutoff head (h0)
    - relative speed setting (w)
    - pump curve coefficients (r, n)

#### GGA

- Global Gradient Algorithm (GGA)
    - iteration 1
    - iteration m
        - (two-step solution)
            - first step: nodal heads
            - second step: link flow
    - iteration n

- GGA (two-step solution)
    - first step
        - nodal heads (h)
            - symmetric coefficient matrix (A - NxN)
                - A_ii --> g_ij
                - A_ij = Aji --> g_ij
                - gradient of the head loss (g_ij)
                    - pipe
                    - pump
            - vector of right hand side terms (F)
                - net flow imbalance
                - flow correction factor
    - second step
        - link flow

