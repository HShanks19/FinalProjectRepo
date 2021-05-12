const ViewReceiverButton = (props) => (
  <>
    <label>View</label>
    <input value={props.search} onInput={props.handleChange} onClick={props.handleClick} />
  </>
);

export default ViewReceiverButton;
