import React from 'react';
import { APIProvider, Map as GoogleMap, Marker } from '@vis.gl/react-google-maps';

const API_KEY = 'AIzaSyCl7oLs_m4NMrswGkW3-QauvPoUfjDMgK8';

const Map = () => {
  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <APIProvider apiKey={API_KEY}>
        <div style={{ width: '1140px', height: '432px' }}>
          <GoogleMap
            style={{ width: '100%', height: '100%' }}
            defaultCenter={{ lat: -34.5922, lng: -58.4064 }}
            defaultZoom={15}
            gestureHandling={'greedy'}
            disableDefaultUI={true}
          >
            <Marker position={{ lat: -34.5922, lng: -58.4064 }} />
          </GoogleMap>
        </div>
      </APIProvider>
    </div>
  );
};

export default Map;