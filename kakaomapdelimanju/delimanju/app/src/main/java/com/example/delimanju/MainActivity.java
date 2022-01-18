//카카오맵을 이용한 델리만쥬 위치 정보앱.

package com.example.delimanju;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        // 중심점 변경 + 줌 레벨 변경
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.56303727086675, 127.0385278799811), 9, true); //중심지는 이 코드를 짰던 왕십리역으로 지정!!

        mapView.getZoomLevel();

        ArrayList<MapPoint> mapPoints = new ArrayList<>();   //델리만쥬가 있는 곳 list
        mapPoints.add(MapPoint.mapPointWithGeoCoord(37.495270004459044, 127.02926203681834)); //강남역 위도 경도.
        mapPoints.add(MapPoint.mapPointWithGeoCoord(37.50608942373552, 127.04824149639047)); // 선릉역 위도 경도
        mapPoints.add(MapPoint.mapPointWithGeoCoord(37.54091613426565, 127.06923304928586)); //건대입구역
        mapPoints.add(MapPoint.mapPointWithGeoCoord(37.48471465309957, 127.0341543878891)); //양재역 위도 경도
        mapPoints.add(MapPoint.mapPointWithGeoCoord(37.54400155113183, 127.04444416000808)); //서울숲역

        for (MapPoint mapPoint:
              mapPoints) {
            addMarker(mapView, mapPoint);
        }

    }

    private void addMarker(MapView mapView, MapPoint mapPoint) {
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("델리만쥬");
        marker.setTag(0);
        marker.setMapPoint(mapPoint);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모

        mapView.addPOIItem(marker);// 양.
    }
}
