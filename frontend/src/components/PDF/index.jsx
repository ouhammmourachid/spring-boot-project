const PDF = ({src}) => {
  return (
    <div className="relative w-1/2 h-full border border-gray-400 overflow-hidden">
      <object
        data={src}
        type="application/pdf"
        className=""
        aria-label="PDF Document"
      />
    </div>
  );
};
  
  export default PDF;