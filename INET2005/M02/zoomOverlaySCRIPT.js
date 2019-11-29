import Map from 'ol/Map.js';
import Overlay from 'ol/Overlay.js';
import View from 'ol/View.js';
import {toStringHDMS} from 'ol/coordinate.js';
import TileLayer from 'ol/layer/Tile.js';
import {fromLonLat, toLonLat} from 'ol/proj.js';
import OSM from 'ol/source/OSM.js';


var layer = new TileLayer({
    source: new OSM()
});

var map = new Map({
    layers: [layer],
    target: 'map',
    view: new View({
        center: [0, 0],
        zoom: 2
    })
});

var pos = fromLonLat([-65.168, 44.885]);

// Vienna marker
var marker = new Overlay({
    position: pos,
    positioning: 'center-center',
    element: document.getElementById('marker'),
    stopEvent: false
});
map.addOverlay(marker);

// Vienna label
var vienna = new Overlay({
    position: pos,
    element: document.getElementById('vienna')
});
map.addOverlay(vienna);

// Popup showing the position the user clicked
var popup = new Overlay({
    element: document.getElementById('popup')
});
map.addOverlay(popup);

map.on('click', function(evt) {
    var element = popup.getElement();
    var coordinate = evt.coordinate;
    var hdms = toStringHDMS(toLonLat(coordinate));

    $(element).popover('destroy');
    popup.setPosition(coordinate);
    $(element).popover({
        placement: 'top',
        animation: false,
        html: true,
        content: '<p>The location you clicked was:</p><code>' + hdms + '</code>'
    });
    $(element).popover('show');
});