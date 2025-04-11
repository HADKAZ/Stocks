import Header from "~/components/header";
import type { Route } from "./+types/home";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "Lateb" },
    { name: "description", content: "L'Association des Teks Experts en Bière" },
  ];
}

export default function Home() {
  return (
    <Header />
  )
}
