import { useSearchParams } from "react-router-dom";

function ContactPage() {
  const [searchParams] = useSearchParams();
  const name = searchParams.get("name");
  const phone = searchParams.get("phone");
  return (
    <div className="w-screen h-screen bg-gray-900 p-6">
      <h1>{name}</h1>
      <p>{phone}</p>
    </div>
  );
}

export default ContactPage;
