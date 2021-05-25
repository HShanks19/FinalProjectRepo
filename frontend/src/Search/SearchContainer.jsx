/* eslint-disable no-unused-vars */
/* eslint-disable react/button-has-type */
import { Button } from 'react-bootstrap';
import { useState, useEffect } from 'react';
import Select from 'react-select';
import SearchResult from './SearchResult';

const SearchContainer = ({
  dataLimit, setDataLimit, pages, setSearchResults, searchResults, formVisible, setFormVisible,
  initialSearchState, setSearchValue, setLoading,
}) => {
  const numberOfResults = searchResults.length;
  const pageLimit = 5;
  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    window.scrollTo({ behavior: 'smooth', top: '0px' });
  }, [currentPage, dataLimit, pages]);

  function goToNextPage() {
    setCurrentPage((page) => page + 1);
  }

  function goToPreviousPage() {
    setCurrentPage((page) => page - 1);
  }

  function changePage(event) {
    const pageNumber = Number(event.target.textContent);
    setCurrentPage(pageNumber);
  }

  const getPaginatedData = () => {
    debugger;
    const startIndex = currentPage * dataLimit - dataLimit;
    const endIndex = startIndex + dataLimit;
    return searchResults.slice(startIndex, endIndex);
  };

  const getPaginationGroup = () => {
    const start = Math.floor((currentPage - 1) / pageLimit) * pageLimit;
    if (pages - currentPage > 5) {
      return new Array(pageLimit).fill().map((_, idx) => start + idx + 1);
    }
    return new Array(pages).fill().map((_, idx) => start + idx + 1);
  };

  function makeFormVisible() {
    setSearchValue(initialSearchState);
    setFormVisible(true);
    setCurrentPage(1);
    setLoading(false);
  }

  // eslint-disable-next-line no-unused-vars
  function sortResultsBy(array, criteria) {
    const cloneArray = JSON.parse(JSON.stringify(array));
    if (criteria === 'forenames_az') {
      return cloneArray.sort((a, b) => a.forenames.localeCompare(b.forenames));
    } if (criteria === 'forenames_za') {
      return cloneArray.sort((a, b) => b.forenames.localeCompare(a.forenames));
    } if (criteria === 'surname_az') {
      return cloneArray.sort((a, b) => a.surname.localeCompare(b.surname));
    }
    return cloneArray.sort((a, b) => b.surname.localeCompare(a.surname));
  }

  const dataLimitOptions = [
    { value: '9', label: '9' },
    { value: '15', label: '15' },
    { value: '21', label: '21' },
    { value: '30', label: '30' },
  ];

  const sortingOptions = [
    { value: 'forenames_az', label: 'Forenames (A-Z)' },
    { value: 'forenames_za', label: 'Forenames (Z-A)' },
    { value: 'surname_az', label: 'Surname (A-Z)' },
    { value: 'surname_za', label: 'Surname (Z-A)' },
  ];

  if (formVisible) {
    return null;
  } if (numberOfResults === 0) {
    return (
      <>
        <h1 className="results-found-text">Sorry... your search found no results.</h1>
        <br />
        <h2 className="results-found-text">Please create a new search using the button below.</h2>
        <br />
        <Button variant="outline-info" onClick={makeFormVisible} className="create-new-search-button"><b>Create new search</b></Button>
      </>

    );
  }

  return (
    <>
      <div className="results-container">
        <span className="search-container-top-row-buttons">
          <Button variant="outline-info" onClick={makeFormVisible} className="create-new-search-button"><b>Create new search</b></Button>
          <p className="results-found-text">
            {numberOfResults}
            {' '}
            result(s) found
          </p>
          <Select
            defaultValue="Set sort"
            className="search-container-sort-select"
            options={sortingOptions}
            onChange={(event) => {
              console.log(event.value);
              setSearchResults(sortResultsBy(searchResults, event.value.toString()));
              // setCurrentPage(1);
            }}
          />
          <Select
            defaultValue="9"
            className="search-container-data-limit-select"
            options={dataLimitOptions}
            onChange={(event) => {
              setDataLimit(Number.parseInt(event.value, 10));
              setCurrentPage(1);
            }}
          />
        </span>
        <br />
        <div className="results-subcontainer">
          <div className="row">
            {getPaginatedData().map((result) => (
              <SearchResult
                firstName={result.forenames}
                lastName={result.surname}
                dateOfBirth={result.dateOfBirth}
                placeOfBirth={result.placeOfBirth}
                address={result.homeAddress}
                citizenId={result.citizenID}
                className="search-card"
              />
            ))}
          </div>
        </div>
      </div>
      <div className="pagination">
        {/* previous button */}
        <Button
          variant="dark"
          onClick={goToPreviousPage}
          className={`prev ${currentPage === 1 ? 'disabled' : ''}`}
        >
          prev
        </Button>

        {/* show page numbers */}
        {getPaginationGroup().map((item) => (
          <Button
            variant="dark"
            onClick={changePage}
            className={`paginationItem ${currentPage === item ? 'active' : null}`}
          >
            <span>{item}</span>
          </Button>
        ))}

        {/* next button */}
        <Button
          variant="dark"
          onClick={goToNextPage}
          className={`next ${currentPage === pages ? 'disabled' : ''}`}
          disabled={currentPage === pages}
        >
          next
        </Button>
      </div>
    </>
  );
};

export default SearchContainer;
