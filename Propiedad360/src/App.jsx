import React from 'react';
import { createRoutes } from './routes/Routes';
import { RouterProvider } from 'react-router-dom';
import { useUser } from './context/UserContext';

function App() {
  const { user, loading } = useUser();

  if (loading) return <div>Cargando...</div>;

  return <RouterProvider router={createRoutes(user)} />;
}

export default App;