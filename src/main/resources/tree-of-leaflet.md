# Leaflet

## API

### Class

- Leaflet
    - LatLng
    - LatLngBounds
    - Point
    - Bounds
    - Class
        - Evented
            - Map
            - Layer
                - Renderer
                    - Canvas
                    - SVG
                - GridLayer
                    - TileLayer
                - ImageOverlay
                    - SVGOverlay
                    - VideoOverlay
                - Path
                    - CircleMarker
                        - Circle
                    - Polyline
                        - Polygon
                            - Rectangle
                - LayerGroup
                    - FeatureGroup
                        - GeoJSON
                - DivOverlay
                    - Popup
                    - Tooltip
                - Marker
        - Control
            - Layers
            - Zoom
            - Scale
            - Attribution
        - Icon
            - DivIcon
        - Handler
            - BoxZoom
            - DoubleClickZoom
            - Drag
            - Keyboard
            - ScrollWheelZoom
            - TapHold
            - TouchZoom

### Map

- L.map
    - div
    - Options
        - Control options
            - attributionControl
            - zoomControl
        - Interaction Options
        - Map State Options
            - crs
            - center
            - zoom
            - minZoom
            - maxZoom
            - layers
            - maxBounds

- map.Events
    - Layer events
    - Map state change events
    - Popup events
    - Tooltip events
    - Location events
    - Interaction events
        - click
        - mouseover
        - mouseout
    - Other Events

- map.Methods
    - Layers and Controls
        - addControl(<Control> control)
        - addLayer(<Layer> layer)
        - openPopup(<Popup> popup)
    - Getting Map State
        - getCenter()
        - getZoom()
        - getMinZoom()
        - getMaxZoom()
        - getBounds()
        - getSize()
    - Modifying map state
        - setView(<LatLng> center, <Number> zoom, <Zoom/pan options> options?)
        - setZoom(<Number> zoom, <Zoom/pan options> options?)
        - setMinZoom(<Number> zoom)
        - setMaxZoom(<Number> zoom)
    - Geolocation methods
        - locate(<Locate options> options?)
        - stopLocate()
    - Conversion Methods
        - project(<LatLng> latlng, <Number> zoom)
        - unproject(<Point> point, <Number> zoom)
    - Other Methods

- map.Properties
    - Controls
        - zoomControl
    - Handlers
        - boxZoom
        - dragging
        - keyboard

### Layer

- Layer
    - Options
        - pane
        - attribution
    - Events
        - add
        - remove
        - Popup events
            - popupopen
            - popupclose
        - Tooltip events
            - tooltipopen
            - tooltipclose
    - Methods
        - addTo(<Map|LayerGroup> map)
        - remove()
        - getPane(<String> name?)
        - getAttribution()
        - Extension methods
            - onAdd(<Map> map)
            - onRemove(<Map> map)
            - getEvents()
            - getAttribution()
        - Popup methods
            - bindPopup(<String|HTMLElement|Function|Popup> content, <Popup options> options?)
            - unbindPopup()
            - openPopup(<LatLng> latlng?)
            - closePopup()
            - togglePopup()

- LayerGroup
    - add
        - addLayer(<Layer> layer)
    - remove
        - removeLayer(<Layer> layer)
        - clearLayers()
    - get
        - all
            - eachLayer(<Function> fn, <Object> context?)
            - getLayers()
        - single
            - hasLayer(<Layer> layer)
    - layerId
        - get
            - getLayerId(<Layer> layer)
            - getLayer(<Number> id)
            - hasLayer(<Number> id)
        - remove
            - removeLayer(<Number> id)
    - zIndex
        - setZIndex(<Number> zIndex)
    - export
        - toGeoJSON(<Number|false> precision?)

## UI Layer

- Layer
    - Marker
    - DivOverlay
        - Popup
        - Tooltip
    - GridLayer (other)
        - TileLayer (raster)
            - TileLayer.WMS (raster)
    - ImageOverlay (raster)
        - VideoOverlay (raster)
        - SVGOverlay (vector)
    - Path (vector)
        - Polyline (vector)
            - Polygon (vector)
                - Rectangle (vector)
        - CircleMarker (vector)
            - Circle (vector)
    - LayerGroup (other)
        - FeatureGroup (other)
            - GeoJSON (other)


- UI Layer
    - Marker
    - DivOverlay
        - Popup
        - Tooltip
    - Raster Layer
        - GridLayer
            - TileLayer
                - TileLayer.WMS
        - ImageOverlay
            - VideoOverlay
            - SVGOverlay
    - Vector Layers
        - Path
            - Polyline
                - Polygon

### Control

- Control
    - Control.Zoom
    - Control.Attribution
    - Control.Layers
    - Control.Scale

### Evented

- Evented
    - Map
    - Layer
        - Marker

- Event
    - KeyboardEvent
    - MouseEvent
        - latlng
    - LocationEvent
    - ErrorEvent
    - LayerEvent
        - layer
    - LayersControlEvent
    - TileEvent
        - tile
        - coords
    - TileErrorEvent
    - ResizeEvent
    - GeoJSONEvent
        - layer
        - properties
        - geometryType
        - id
    - PopupEvent
    - TooltipEvent
    - DragEndEvent
    - ZoomAnimEvent

## leaflet.draw

- leaflet.draw
    - Class
        - Toolbar
            - DrawToolbar
            - EditToolbar
        - Control
            - Draw

## L.geoJSON

- L.geoJSON
    - geojson
    - options
        - style
            - pointToLayer (point)
            - style (polyline + polygon)
        - iterator
            - onEachFeature
            - filter


