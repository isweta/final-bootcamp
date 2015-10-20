<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	font: 10px sans-serif;
}

.axis path, .axis line {
	fill: none;
	stroke: #000;
	shape-rendering: crispEdges;
}

.overlay {
	fill: none;
	pointer-events: all;
}

.line {
	fill: none;
	stroke: steelblue;
	stroke-width: 1.5px;
}

.focus circle {
	fill: none;
	stroke: steelblue;
}
</style>

<script>
	var request;
	function sendInfo() {
		//var v=document.vinform.t1.value;  
		console.log("reached");
		var url = "DataServlet";

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}

		try {
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					var val = request.responseText;
					//document.getElementById('amit').innerHTML=val;  
					if (val != null)
						showGraph(val);
				}
			};
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}

	}

	function showGraph(val1) {
		//console.log(val1);
		JSON.parse('{"result":true,"count":1}');
		var val = JSON.parse('[' + val1 + ']');
		//console.log(val);	  
		var dataset1 = val;

		var margin = {
			top : 20,
			right : 0,
			bottom : 30,
			left : 40
		}, width = 1900 - margin.left - margin.right, height = 900 - margin.top
				- margin.bottom;

		//var parseDate = d3.time.format("%Y%m%d").parse;
		var x = d3.scale.ordinal().rangeRoundBands([ 0, width ], .2);
		var y = d3.scale.linear().rangeRound([ height, 0 ]);
		var color = d3.scale.category10();

		var xAxis = d3.svg.axis().scale(x).orient("bottom");

		var yAxis = d3.svg.axis().scale(y).orient("left");

		var line = d3.svg.line().interpolate("basis").x(function(d) {
			return x(d.Timestamp);
		}).y(function(d) {
			return y(d.qValue);
		});

		var svg = d3.select("body").append("svg").attr("width",
				width + margin.left + margin.right).attr("height",
				height + margin.top + margin.bottom).append("g").attr(
				"transform",
				"translate(" + margin.left + "," + margin.top + ")");

		svg.append("g").attr("class", "x axis").attr("transform",
				"translate(0," + height + ")").append("text").attr("x", width)
				.style("text-anchor", "end").text("Time");

		svg.append("g").attr("class", "y axis").append("text").attr(
				"transform", "rotate(-90)").attr("y", 6).attr("dy", ".71em")
				.style("text-anchor", "end").text("Bandwidth in KBps");

		
		update(dataset1);

		/* var transitionInterval = setInterval(function () {
		update(dataset2);
		}, 1000);  */

		function update(dataset) {

			bisectDate = d3.bisector(function(d) {
				return d.Timestamp;
			}).left
			color.domain(d3.keys(dataset[0]).filter(function(key) {
				return key !== "Timestamp";
			}));

			console.log(d3.keys(dataset[0]));

			var efteValues = color.domain().map(function(name) {
				return {
					name : name,
					values : dataset.map(function(d) {
						return {
							Timestamp : d.Timestamp,
							qValue : +d[name]
						};
					})
				};
			});
			console.log(efteValues[0]);

			x.domain(dataset.map(function(d) {
				return d.Timestamp;
			}));

			/*  y.domain([
			 d3.min(efteValues, function (c) {
			     return d3.min(c.values, function (v) {
			         return v.qValue;
			     });
			 }),
			 d3.max(efteValues, function (c) {
			     return d3.max(c.values, function (v) {
			         return v.qValue;
			     });
			 })]);  */

			y.domain([ 0, 2048 ]);

			// update axes
			d3.transition(svg).select('.y.axis').call(yAxis);

			d3.transition(svg).select('.x.axis').call(xAxis);

			var city = svg.selectAll(".city").data(efteValues);

			var cityEnter = city.enter().append("g").attr("class", "city");

			cityEnter.append("path").attr("class", "line").attr("d",
					function(d) {
						return line(d.values);
					}).style("stroke", function(d) {
				return color(d.name);
			});
			cityEnter.append("text").datum(function(d) {
				return {
					name : d.name,
					value : d.values[d.values.length - 1]
				};
			}).attr(
					"transform",
					function(d) {
						return "translate(" + x(d.value.Timestamp) + ","
								+ y(d.value.qValue) + ")";
					}).attr("x", -100).attr("dy", -3).text(function(d) {
				return d.name;
			});

			// transition by selecting 'city'...
			cityUpdate = d3.transition(city);

			// ... and each path within
			cityUpdate.select('path').transition().duration(600).attr("d",
					function(d) {
						return line(d.values);
					});

			city.exit().remove();

		}

	}
</script>




<body onload="sendInfo();">

	<%
		response.setIntHeader("Refresh", 6);
	%>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>




</body>


</html>