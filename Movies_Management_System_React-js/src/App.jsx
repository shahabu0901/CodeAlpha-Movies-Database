import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./component/Navbar";
import SearchMovies from "./pages/SearchMovies";
import AddMovies from "./pages/AddMovies";
import AllMovies from "./pages/AllMovies";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<SearchMovies />} />
        <Route path="/add" element={<AddMovies />} />
        <Route path="/allMovies" element={<AllMovies />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
