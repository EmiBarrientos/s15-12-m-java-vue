import React from 'react';
import { APIProvider, Map as GoogleMap } from '@vis.gl/react-google-maps';

const API_KEY = 'TU_API_KEY'; // Reemplaza con tu propia API Key


const Mapa = () => {
  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <APIProvider apiKey={API_KEY}>
        <div style={{ width: '1140px', height: '432px' }}>
          <GoogleMap
            style={{ width: '100%', height: '100%' }}
            defaultCenter={{ lat: 22.54992, lng: 0 }}
            defaultZoom={3}
            gestureHandling={'greedy'}
            disableDefaultUI={true}
          />
        </div>
      </APIProvider>
    </div>
  );
};
export default Mapa;
