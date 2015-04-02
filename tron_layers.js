

var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

var pi = Math.PI, tau = pi * 2, deg = pi / 180;
// var start = Math.random()*tau;
// var end = Math.random()*tau;
var drawMaze = function(x, y, radius, number, increment, hue) {
	var getHslString = function(hue) {
		return "hsl(" + hue + ", 100%, 50%)";
	};
	// var getPosition = function() {
	// 	return Math.random()*tau;
	// }
	var getDirection = function() {
		var direction = Math.round(Math.random());
		if (direction == 0) {
			return false;
		} else {
			return true;
		}
	};
	hue = Math.round(Math.random()*1000);
	var color = getHslString(hue);
	var start = Math.random()*tau;
	var end = Math.random()*tau;
	
	context.strokeStyle = color || "#fff";
	context.beginPath();
	context.arc(x, y, radius, start, end, getDirection());
	context.stroke();

	var startSub = end;
	for (i = 1; i < number; i++) {
		radius += increment;
		var endSub = Math.random()*tau;
		context.strokeStyle = color;
		context.arc(x, y, radius, startSub, endSub, getDirection());
		startSub = endSub;
	}
		hue = Math.round(Math.random()*1000);
		var color = getHslString(hue);
		context.stroke();
};



drawMaze(256, 256, 25, 25, 25, 0);
drawMaze(256, 256, 25, 25, 25, 0);

