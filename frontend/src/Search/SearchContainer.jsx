/* eslint-disable react/button-has-type */
import { Button } from 'react-bootstrap';
import { useState, useEffect } from 'react';
import Select from 'react-select';
import SearchResult from './SearchResult';

const SearchContainer = ({
  dataLimit, setDataLimit, pages, searchResults, formVisible, setFormVisible,
}) => {
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
    setFormVisible(true);
  }

  const dataLimitOptions = [
    { value: '9', label: '9' },
    { value: '15', label: '15' },
    { value: '21', label: '21' },
    { value: '30', label: '30' },
  ];

  if (formVisible) {
    return null;
  }

  return (
    <>
      <div className="results-container">
        <span className="search-container-top-row-buttons">
          <Button variant="outline-info" onClick={makeFormVisible} className="create-new-search-button"><b>Create new search</b></Button>
          <Select
            defaultValue="9"
            className="search-container-data-limit-select"
            options={dataLimitOptions}
            onChange={(event) => {
              setDataLimit(event.value);
              setCurrentPage(1);
            }}
          />
        </span>
        <br />
        <div className="results-subcontainer">
          <div className="row">
            {getPaginatedData().map((result) => (
              <SearchResult
                firstName={result.firstName}
                lastName={result.lastName}
                dateOfBirth={result.dateOfBirth}
                placeOfBirth={result.placeOfBirth}
                address={result.address}
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
