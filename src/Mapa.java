import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;

public class Mapa extends MapView{
	
	
	private static Map map;
	public Mapa(String nName)
	{
		JFrame frame = new JFrame(nName);
		
		setOnMapReadyHandler(new MapReadyHandler() {
			
			@Override
			public void onMapReady(MapStatus status) {
			
				if(status== MapStatus.MAP_STATUS_OK)
				{
					map= getMap();
					
					MapOptions mapOptions = new MapOptions();
					MapTypeControlOptions controlOptions= new MapTypeControlOptions();
					mapOptions.setMapTypeControlOptions(controlOptions);
					
					map.setOptions(mapOptions);
					map.setCenter(new LatLng(41.8316578,-87.6374727));
					map.setZoom(11.0);
					
				
					
					Circle circle = new Circle(map);
					
					circle.setCenter(map.getCenter());
					circle.setRadius(400);
					
					CircleOptions co= new CircleOptions();
					co.setFillColor("#FF0000");
					co.setFillOpacity(0.35);
					
					circle.setOptions(co);
					
					
				}
				
				
				
			}
		});
		
		frame.add(this,BorderLayout.CENTER);
		frame.setSize(700, 500);
		frame.setVisible(true);
		
		
		
	}

	public Marker generateMarker(LatLng pos)
	{
		Marker marker = new Marker(map);
		marker.setPosition(pos);
		return marker;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mapa temp= new Mapa("ventana de prueba");
		
		temp.generateMarker(map.getCenter());

	}

}
