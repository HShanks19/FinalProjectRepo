import SearchResult from './SearchResult';

const SearchContainer = ({ searchValue, setSearchValue, searchResults }) => {
  const searchResultsAsJSX = searchResults.map((result) => (
    <SearchResult
      firstName={result.firstName}
      lastName={result.lastName}
      dateOfBirth={result.dateOfBirth}
      placeOfBirth={result.placeOfBirth}
      address={result.address}
      className="search-card"
    />
  ));

  const makeFormVisible = () => {
    setSearchValue({ shouldShow: true });
  };

  if (searchValue.shouldShow) {
    return null;
  }

  return (
    <>
      <br />
      <a href="localhost:3000/" onClick={makeFormVisible}>New search</a>
      <br />
      <br />
      {searchResultsAsJSX}
    </>
  );
};

export default SearchContainer;
