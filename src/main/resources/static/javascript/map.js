var mapContainer = document.getElementById('map')// 지도를 표시할 div

var mapOption = {
    center: new kakao.maps.LatLng(geo_latitude, geo_longitude), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var geo_latitude = null;
var geo_longitude = null;

if(navigator.geolocation){
    navigator.geolocation.getCurrentPosition(function(position){
        geo_latitude = position.coords.latitude;
        geo_longitude = position.coords.longitude;
    });
}

var lat = null;
var lng = null;

getSavedLocations();

//-------------------------------- DB 정보 가져오기 시작 --------------------------------
 function getSavedLocations() {
    $.ajax({
        type: 'get',
        url: "/information",
        dataType: "json",

        success: function (data) {
            for(var i = 0; i < data.length; i++){
                // DB에 저장된 장소의 좌표정보 입니다.
                var markerPosition = new kakao.maps.LatLng(data[i].latitude, data[i].longitude);

                // 마커를 생성합니다.
                var marker = new kakao.maps.Marker({
                    position: markerPosition
                });

                //마커가 지도 위에 표시되록 설정합니다.
                marker.setMap(map);
            }
        },
        error: function(){
            console.log("통신에러");
        }
    })

 }
//-------------------------------- DB 정보 가져오기 끝 --------------------------------


//-------------------------------- 새로운 마커 추가 기능 시작 --------------------------------

// 지도를 클릭했을때 클릭한 위치에 마커를 추가하도록 지도에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

    // 클릭한 위도, 경도 정보를 가져옵니다
    lat = mouseEvent.latLng.getLat();
    lng = mouseEvent.latLng.getLng();

    // 클릭한 위치에 마커를 표시합니다
    addMarker(mouseEvent.latLng);

    // 모달 띄우기
    $('#myModal').modal('show');

});

// 마커를 생성하고 지도위에 표시하는 함수입니다
function addMarker(position) {
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: position,
        clickable: true
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
}

$("#btn-map-write").on("click",()=>{
    let data = {
            latitude: lat,
            longitude: lng,
            content: $("#content").val()
    };

    $.ajax({
        type: "POST",
        url: "/coordinate",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function(resp){
        alert("새로운 장소가 등록되었습니다.");
        location.href="/";
    }).fail(function(error){
        alert(JSON.stringify(error));
    });

});

//-------------------------------- 새로운 마커 추가 기능 끝 --------------------------------



//-------------------------------- 지도 컨트롤러 시작 --------------------------------

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//-------------------------------- 지도 컨트롤러 끝 --------------------------------