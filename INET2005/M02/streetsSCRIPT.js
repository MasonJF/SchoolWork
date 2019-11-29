import Map from 'ol/Map.js';
import View from 'ol/View.js';
import {getCenter} from 'ol/extent.js';
import GeoJSON from 'ol/format/GeoJSON.js';
import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer.js';
import BingMaps from 'ol/source/BingMaps.js';
import VectorSource from 'ol/source/Vector.js';
import {Fill, Style, Text} from 'ol/style.js';
import {fromLonLat} from "ol/proj";

var style = new Style({
    text: new Text({
        font: 'bold 11px "Open Sans", "Arial Unicode MS", "sans-serif"',
        placement: 'line',
        fill: new Fill({
            color: 'white'
        })
    })
});

var viewExtent = [48882.42557913007,4693952.106754928,971221.7702578196,5283841.828201038];
var map = new Map({
    layers: [new TileLayer({
        source: new BingMaps({
            key: 'AvixFBo79BNSwJ_h_Cuzpp_9jAmZebzB4McwX8S43wFPneVeteqs68DJ8pBtRpv_',
            imagerySet: 'Aerial'
        }),
    }), new VectorLayer({
        declutter: true,
        source: new VectorSource({
            format: new GeoJSON(),
            url: 'https://raw.githubusercontent.com/MasonJF/plswork/master/map(4).geojson'
        }),
        style: function(feature) {
            style.getText().setText(feature.get('name'));
            return style;
        }
    })],
    target: 'map',
    view: new View({
        // extent: viewExtent,
        center: fromLonLat([-65.168, 44.885]),
        zoom: 17,
        minZoom: 14
    })
});