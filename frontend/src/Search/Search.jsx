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
  });

  const [formVisible, setFormVisible] = useState(true);

  const [searchResults, setSearchResults] = useState([]);

  const [dataLimit, setDataLimit] = useState(9);

  function obtainData() {
    axios.get('https://my-json-server.typicode.com/joshua-hs/fake-final-api/citizens')
      .then((response) => {
        setSearchResults(response.data);
        setFormVisible(false);
      })
      .catch((err) => console.log(err));
  }

  return (
    <>
      <SearchForm
        searchValue={searchValue}
        setSearchValue={setSearchValue}
        obtainData={obtainData}
        formVisible={formVisible}
      />
      <SearchContainer
        dataLimit={dataLimit}
        setDataLimit={setDataLimit}
        pages={Math.ceil(searchResults.length / dataLimit)}
        searchResults={searchResults}
        formVisible={formVisible}
        setFormVisible={setFormVisible}
      />
    </>
  );
};

export default Search;
