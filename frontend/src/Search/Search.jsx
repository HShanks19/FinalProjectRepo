import { useState } from 'react';
import axios from 'axios';
import SearchForm from './SearchForm';
import SearchContainer from './SearchContainer';

const Search = () => {
  const [searchValue, setSearchValue] = useState({
    firstName: '',
    lastName: '',
    dateOfBirth: '',
    placeOfBirth: '',
    address: '',
    title: '',
    shouldShow: true,
  });

  const [citizens, setCitizens] = useState([]);

  const obtainData = () => {
    axios.get('https://my-json-server.typicode.com/joshua-hs/fake-final-api/citizens')
      .then((response) => {
        setCitizens(response.data);
        setSearchValue({ shouldShow: false });
      })
      .catch((err) => console.log(err));
  };

  return (
    <>
      <SearchForm
        searchValue={searchValue}
        setSearchValue={setSearchValue}
        obtainData={obtainData}
      />
      <SearchContainer
        searchValue={searchValue}
        setSearchValue={setSearchValue}
        searchResults={citizens}
      />
    </>
  );
};

export default Search;
