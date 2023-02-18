# GeoJSON

- GeoJSON types(9)
    - geometry type(7)
        - (1) Point
        - (2) MultiPoint
        - (3) LineString
        - (4) MultiLineString
        - (5) Polygon
        - (6) MultiPolygon
        - (7) GeometryCollection
    - (8) Feature
    - (9) FeatureCollection

- CoordinateReferenceSystem
    - crsId
    - name
    - CoordinateSystem

- CoordinateReferenceSystem
    - SingleCoordinateReferenceSystem
        - GeocentricCartesianCoordinateReferenceSystem
        - GeographicCoordinateReferenceSystem
            - Geographic2DCoordinateReferenceSystem
            - Geographic3DCoordinateReferenceSystem
        - LinearCoordinateReferenceSystem
        - ProjectedCoordinateReferenceSystem
        - VerticalCoordinateReferenceSystem
    - CompoundCoordinateReferenceSystem

- CoordinateSystem
    - C2D: CartesianCoordinateSystem2D
    - C3D: CartesianCoordinateSystem3D
    - C2DM: CartesianCoordinateSystem2DM
    - C3DM: CartesianCoordinateSystem3DM
    - G2D: EllipsoidalCoordinateSystem2D
    - G3D: EllipsoidalCoordinateSystem3D
    - G2DM: EllipsoidalCoordinateSystem2DM
    - G3DM: EllipsoidalCoordinateSystem3DM

- Position
    - C2D: A position in a cartesian coordinate reference system.
        - C2DM: A cartesian Position with a measure value.
        - C3D: A cartesian Position having an z-value.
            - C3DM: A cartesian Position with both an z and a measure value.
    - G2D: A Position in a geographic coordinate reference system.
        - G2DM: A geographic Position with a measure value.
        - G3D: A geographic Position with an altitude.
            - G3DM: A geographic Position with both an altitude and a measure value.
    - M
    - V
