import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.teamdev.jxmaps.swing.MapView;

import com.teamdev.jxmaps.*;

public class Mapa extends MapView{
	

	private static Map map;


	private CircleOptions settingsCircle;

	private  PolylineOptions settingsLine;

	public CircleOptions getSettingsCircle() {
		return settingsCircle;
	}

	public void setSettingsCircle(CircleOptions settingsCircle) {
		this.settingsCircle = settingsCircle;
	}





	/**
	 * Genera un marcador en la posicion que llega por parametro
	 * @param pos poscicion deseada para el marcador
	 * @return marcador creado
	 */
	public Marker generateMarker(LatLng pos,Map pMap)
	{
		Marker marker=null;
	
			
			 marker = new Marker(pMap);
			marker.setPosition(pos);
			pMap.setCenter(pos);
	
		System.out.println("Graficado marker");
		return marker;
	}

	public void generateSimplePath(LatLng start,LatLng end,Boolean markers,Map pMap)
	{
		LatLng[] path = {start,end};
		Polyline polyline = new Polyline(pMap);
		polyline.setPath(path);
		if(markers)
		{
			generateMarker(start,pMap);
			generateMarker(end,pMap);
		}
	}

	public Map darMap()
	{
		return map;
	}

	/**
	 * 
	 * @param center
	 * @param radiusen en metros
	 */
	public void generateArea(LatLng center,Double radius,Map pMap)
	{
		Circle circle = new Circle(pMap);
		circle.setCenter(center);
		circle.setRadius(radius);
		circle.setVisible(true);
		circle.setOptions(settingsCircle);
	}

	/**
	 * 
	 * @param markers colocar marcadores en cada punto de la linea
	 * @param path
	 */
	public void GenerateLine(boolean markers,Map pMap,LatLng... path)
	{
		if(markers)
		{
			for(LatLng p:path)
			{
				generateMarker(p,pMap);
			}
		}
		Polyline polyline = new Polyline(pMap);
		polyline.setPath(path);
	}

	public Mapa(String pString) {

		JFrame frame = new JFrame("Chicago-Data: "+pString);


		settingsCircle=new CircleOptions();
		settingsCircle.setFillColor("#FF0000");
		settingsCircle.setRadius(2000000);
		settingsCircle.setFillOpacity(0.35);

		settingsLine=new PolylineOptions();
		settingsLine.setGeodesic(true);
		settingsLine.setStrokeColor("#FF0000");
		settingsLine.setStrokeOpacity(1.0);
		settingsLine.setStrokeWeight(2.0);

		// Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
		// the map object is ready to use. Current implementation of onMapReady customizes the map object.
		setOnMapReadyHandler(new MapReadyHandler() {
			@Override
			public void onMapReady(MapStatus status) {
				// Check if the map is loaded correctly
				if (status == MapStatus.MAP_STATUS_OK) {
					// Getting the associated map object
					map = getMap();
					MapOptions mapOptions = new MapOptions();
					MapTypeControlOptions controlOptions = new MapTypeControlOptions();
					controlOptions.setPosition(ControlPosition.BOTTOM_LEFT);
					mapOptions.setMapTypeControlOptions(controlOptions);
					
					map.setOptions(mapOptions);
					map.setCenter(new LatLng(42.045527, -88.037659));
					map.setZoom(10);

				}
			}
		});
		System.out.print("Espere mientras se genera el mapa ");
		try {
			for(int i=0;i<10;i++)
			{
				TimeUnit.SECONDS.sleep(1);
				System.out.print(".");
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("|");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(this, BorderLayout.CENTER);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Mapa example = new Mapa("test");
		
	

	}



}
