/* eslint-disable no-unused-vars */
/* eslint-disable max-len */
import { useState } from 'react';
import axios from 'axios';
import SearchForm from './SearchForm';
import SearchContainer from './SearchContainer';

const Search = () => {
  const initialSearchState = {
    forenames: '',
    surname: '',
    dateOfBirth: '',
    placeOfBirth: '',
    homeAddress: '',
  };
  const [searchValue, setSearchValue] = useState(initialSearchState);

  const [formVisible, setFormVisible] = useState(true);

  const [searchResults, setSearchResults] = useState([]);

  const [dataLimit, setDataLimit] = useState(9);

  const [loading, setLoading] = useState(false);

  function testPostRequest() {
    const postObject = Object.fromEntries(Object.entries(searchValue).filter(([_, value]) => value !== ''));
    console.log(postObject);
    console.log(searchValue);

    axios.post('http://54.74.11.52:5001/getMatchingCitizens/', postObject)
      .then((response) => {
        console.log(response.data);
        setSearchResults(response.data.sort((a, b) => a.surname.localeCompare(b.surname)));
        setFormVisible(false);
      })
      .catch((err) => console.log(err));
  }

  function obtainData() {
    axios.get('http://54.74.6.120:5001/getMatchingCitizens/')
      .then((response) => {
        setSearchResults(response.data);
        setFormVisible(false);
      })
      .catch((err) => console.log(err));
  }

  return (
    <>
      <SearchForm
        testPostRequest={testPostRequest}
        searchValue={searchValue}
        setSearchValue={setSearchValue}
        obtainData={obtainData}
        formVisible={formVisible}
        initialSearchState={initialSearchState}
        loading={loading}
        setLoading={setLoading}
      />
      <SearchContainer
        dataLimit={dataLimit}
        setDataLimit={setDataLimit}
        pages={Math.ceil(searchResults.length / dataLimit)}
        setSearchResults={setSearchResults}
        searchResults={searchResults}
        formVisible={formVisible}
        setFormVisible={setFormVisible}
        setSearchValue={setSearchValue}
        initialSearchState={initialSearchState}
        setLoading={setLoading}
      />
    </>
  );
};

export default Search;
