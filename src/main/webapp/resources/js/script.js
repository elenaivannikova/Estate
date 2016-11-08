$(document)
		.ready(
				function() {

					$("#showViewingsForm").submit(function(e) {
						e.preventDefault();
						myajax();
					});

					function myajax() {
						$("#ajaxResponse").html("");
						$
								.ajax({
									url : 'get-reviews-by-date',
									type : 'POST',
									data : $('#showViewingsForm').serialize(),
									dataType : "json",

									success : function(data) {

										if (data.length != 0) {

											$("#ajaxResponse")
													.append("<thead>");
											$("#ajaxResponse")
													.append(
															"<tr><th>Time</th><th>Address</th><th>First name</th><th>Last name</th><th>Phone</th></tr>");
											$("#ajaxResponse").append(
													"</thead>");

											$("#ajaxResponse")
													.append("<tbody>");

											for (var i = 0; i < data.length; i++) {
												var date = new Date(
														data[i].datetime);
												var str = "";
												if (date.getHours() < 10) {
													str += "0"
												}
												str += date.getHours() + ":";
												if (date.getMinutes() < 10) {
													str += "0"
												}
												str += date.getMinutes();

												$("#ajaxResponse")
														.append(
																"<tr><td>"
																		+ str
																		+ "</td><td>"
																		+ data[i].address
																		+ "</td><td>"
																		+ data[i].firstname
																		+ "</td><td>"
																		+ data[i].lastname
																		+ "</td><td>"
																		+ data[i].phone
																		+ "</td></tr>");
											}
											$("#ajaxResponse").append(
													"</tbody>");
										} else {
											$("#ajaxResponse")
													.html(
															"<b>Request returned no results.</b>");
										}
									},
									error : function(data) {
										$("#ajaxResponse")
												.html(
														"<b>Request returned no results.</b>");
									}
								});
					}

					// ///////////////////////////////////////////////////////////////////////////////////////

					$("#searchForm").submit(function(e) {
						e.preventDefault();
						myajax2();
					});

					function myajax2() {
						$("#ajaxResponse").html("");
						$
								.ajax({
									url : 'execute-search',
									type : 'POST',
									data : $('#searchForm').serialize(),
									dataType : "json",

									success : function(data) {

										if (data.length != 0) {

											$("#ajaxResponse")
													.append("<thead>");
											$("#ajaxResponse")
													.append(
															"<tr><th>Address</th><th>Square</th></tr>");
											$("#ajaxResponse").append(
													"</thead>");

											$("#ajaxResponse")
													.append("<tbody>");

											for (var i = 0; i < data.length; i++) {

												$("#ajaxResponse")
														.append(
																"<tr><td><a href='sign-for-review?id="
																		+ data[i].id
																		+ "'>"
																		+ data[i].address
																		+ "</a></td><td>"
																		+ data[i].square
																		+ " m<sup>2</sup></td></tr>");
											}
											$("#ajaxResponse").append(
													"</tbody>");
										} else {
											$("#ajaxResponse")
													.html(
															"<b>Request returned no results.</b>");
										}
									},
									error : function(data) {
										$("#ajaxResponse")
												.html(
														"<b>Request returned no results.</b>");
									}
								});
					}
				});