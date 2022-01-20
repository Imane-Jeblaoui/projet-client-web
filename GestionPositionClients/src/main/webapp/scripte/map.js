/**
 * 
 */

// Initialize and add the map
/*var lat;
var lng;
$(document).ready(function() {

	$("#submitt").click(function() {
		var queryString = window.location.search;

		var urlParams = new URLSearchParams(queryString);
		var id = urlParams.get('id');
		console.log(id);
		console.log('lng ', lng);
		console.log('lat ', lat);
		var date = $("#inputDate").val();
		console.log(date);
		if (lng != null && lat != null && id != null) {
			$.ajax({
				url: "PositionServlet ",
				data: { action: "add", id: id, lat: lat, lng: lng, date: date},
				method: "POST",
				success: function(data) {
					console.log(data);
					//listerProf(data);
					window.location = '/index.html';
				},
				error: function(data) {
					console.log(data);
				}
			});
		}
	});


});
function initMap() {
	// The location of Uluru
	var uluru = { lat: 31.630000, lng: -8.008889 };
	// The map, centered at Uluru
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 8,
		center: uluru,
	});
	//listener for click on map
	google.maps.event.addListener(map, 'click',
		function(event) {
			lat = event.latLng.lat()
			lng = event.latLng.lng()
			//alert(event.latLng.lat() + "-" + event.latLng.lng())
			var marker = new google.maps.Marker({
				position: event.latLng,
				map: map,
			});
		});
	// The marker, positioned at Uluru
	var marker = new google.maps.Marker({
		position: uluru,
		map: map,
	});
	/*var inf= new google.maps.InfoWindow({
		content:'<h1>Marrakech elbhja</h1>'
	});
	marker.addListener('click',function(){
		inf.open(map,marker);
	});
}*/
$(document).ready(function() {
	var map = L.map('map').setView([31.63, -8.008889], 13);
	const attribution = 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors';
	L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors',
	}).addTo(map);
	var markerGroup = L.layerGroup().addTo(map);
	L.marker([31.63, -8.008889]).addTo(markerGroup);

	function onMapClick(e) {
		markerGroup.clearLayers();
		L.marker(e.latlng).addTo(markerGroup);
		$('#lat').val(e.latlng.lat);
		$('#longi').val(e.latlng.lng);
		let dt = (new Date()).toISOString();
		$('#datee').val(dt.split('-')[0] + '-' + dt.split('-')[1] + '-' + dt.split('-')[2].substring(0, 2));
	}

	map.on('click', onMapClick);

	$('#rechercheSmart').click(function(e) {
		e.preventDefault();
		var imei = $('#idSmartphone').val();
		$.ajax({
			url: "PositionController",
			data: { action: "phone", id: imei },
			method: "POST",
			success: function(data) {
				console.log(data);
				$('#idSmart').val(data.id);
				$('#NomUser').val(data.utilisateur.nom);
				//listerProf(data);
				
			},
			error: function(data) {
				console.log(data);
			}
		});
	});

	

});
